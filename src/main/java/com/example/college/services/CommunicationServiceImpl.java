package com.example.college.services;

import com.example.college.adapters.EmailAdapter;
import com.example.college.adapters.WhatsappAdapter;
import com.example.college.exceptions.InvalidBatchException;
import com.example.college.exceptions.InvalidUserException;
import com.example.college.exceptions.UnAuthorizedAccessException;
import com.example.college.models.*;
import com.example.college.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommunicationServiceImpl implements CommunicationService{
    private UserRepository userRepository;
    private BatchRepository batchRepository;
    private CommunicationLearnerRepository communicationLearnerRepository;
    private BatchLearnerRepository batchLearnerRepository;
    private LearnerRepository learnerRepository;
    private CommunicationRepository communicationRepository;
    private EmailAdapter emailAdapter;
    private WhatsappAdapter whatsappAdapter;
    @Autowired
    public CommunicationServiceImpl(UserRepository userRepository,
                                    BatchRepository batchRepository,
                                    CommunicationLearnerRepository communicationLearnerRepository,
                                    BatchLearnerRepository batchLearnerRepository,
                                    LearnerRepository learnerRepository,
                                    CommunicationRepository communicationRepository,
                                    EmailAdapter emailAdapter,
                                    WhatsappAdapter whatsappAdapter){
        this.userRepository=userRepository;
        this.batchRepository=batchRepository;
        this.communicationLearnerRepository=communicationLearnerRepository;
        this.batchLearnerRepository=batchLearnerRepository;
        this.learnerRepository=learnerRepository;
        this.communicationRepository=communicationRepository;
        this.emailAdapter=emailAdapter;
        this.whatsappAdapter=whatsappAdapter;
    }
    @Override
    public Communication broadcastMessage(long batchId, long userId, String message) throws InvalidBatchException, InvalidUserException, UnAuthorizedAccessException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new InvalidUserException("User not Found");
        }
        User user = userOptional.get();
        if(user.getUserType() != UserType.ADMIN) {
            throw new UnAuthorizedAccessException("User not authorised to send Broadcast Message");
        }
        Optional<Batch> batchOptional = batchRepository.findById(batchId);
        if(batchOptional.isEmpty()){
            throw new InvalidBatchException("Batch ID is not valid");
        }
        Communication communication = new Communication();
        communication.setBatch(batchOptional.get());
        communication.setSentBy(user);
        communication.setMessage(message);
        communicationRepository.save(communication);

        List<BatchLearner> learnersList = batchLearnerRepository.findByBatchIdAndExitDateIsNull(batchId);
        for(BatchLearner learner : learnersList){
            boolean emailFailed = false;
            boolean whatsAppFailed = false;
            try {
                emailAdapter.sendEmail(learner.getLearner().getEmail(),message);

            }catch (Exception e){
                System.out.println("Email Failed");
                emailFailed = true;
            }

            try{
                whatsappAdapter.sendWhatsappMessage(learner.getLearner().getPhoneNumber(),message);
            }catch (Exception e){
                System.out.println("Whats failed");
                whatsAppFailed=true;
            }
            CommunicationLearner communicationLearner = new CommunicationLearner();
            communicationLearner.setCommunication(communication);
            communicationLearner.setLearner(learner.getLearner());
            communicationLearner.setEmailDelivered(emailFailed);
            communicationLearner.setWhatsappDelivered(whatsAppFailed);
            communicationLearnerRepository.save(communicationLearner);
        }




        return communication;
    }
}
