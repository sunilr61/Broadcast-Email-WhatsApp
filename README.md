# Implement functionality which will broadcast important messages to learners

## Problem Statement

You are building web application for College. As a part of this system, you need to implement a functionality which will broadcast important messages to learners. This functionality will be used by the admin team to broadcast important messages to learners.

## Solution

* This functionality will be available for admin users only.
* The input to this functionality will be a message, a batch id and user id (of the user trying to broadcast the message).
* This message should be sent to all the learners via email and a whatsapp direct message.
* Details about every message that is being sent is captured in a table `communications` tracked via Communication entity.
* Whatsapp message and email will be sent via Sendgrid which is a third party service. This library can change in the future, so please keep this integration extensible.
* Details about every message being sent should be stored in a table named `communication_learners` tracked via CommunicationLearner entity.
* Note: Message should only be sent to learners whose current batch id matches the batch id provided in the input. 
* If a learner was part of this batch in the past, but is not part of this batch anymore, then the message should not be sent to this learner.
* Return communication object in response once the emails and whatsapp messages are sent.


