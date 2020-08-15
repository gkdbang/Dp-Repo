const user_controller = require('../User/controller/user.controller');
const questionController=require('../Question/controller/question.Controller');
const questionUpload=require('../Question/controller/questionUploadController');
const challengeController=require('../Challenge/controller/challenge.Controller');
const resultController=require('../Result/controller/result.controller');
const http = require('http');

const express = require('express');
const router = express.Router();


// a simple test url to check that all of our files are communicating correctly.
router.get('/test', user_controller.test);
router.post('/regis',user_controller.regis);
router.put('/user/update/:id',user_controller.updateUser);
router.put('/user/deActivate',user_controller.deActivateUsers);
router.put('/user/activate',user_controller.activateUsers);
router.post('/user/deActivate?:emailId',user_controller.deActivateOneUser);
router.post('/user/activate?:emailId',user_controller.activateOneUser);
router.get('/user',user_controller.getAllUser);
router.post('/user?:emailId',user_controller.getUserByEmailId);
router.post('/login', user_controller.loginUser);
router.get('/login', user_controller.loginUser);
router.post('/Question',questionController.createQuestion);
router.post('/user/changePassword',user_controller.changePassword);

// Question API
router.post('/question',questionController.createQuestion);
router.get('/question',questionController.getAllQuestions);
router.get('/question/:id',questionController.getOneQuestion);
// router.get('/question?:questionType',questionController.getQuestionByQuestionType);
router.put('/question?:id',questionController.updateQuestion);
router.delete('/question?:id',questionController.deleteQuestion);

// Question excel Upload and read API
router.post('/question/upload',questionUpload.uploadQuestion);

// Challenge API
router.post('/challenge',challengeController.createChallenge);
router.get('/challenge',challengeController.getAllChallenge);
router.get('/challenge/:id',challengeController.getOneChallenge);
router.get('/challengeById/:challengeId',challengeController.getChallengeBychallengeId);
router.get('/challengeByName/:challengeName',challengeController.getChallengeBychallengeName);
router.put('/challenge',challengeController.updateChallenge);
router.delete('/challenge?:id',challengeController.deleteChallenge);
//router.post('/challengedeActivate?:challengeId',challengeController.deActivateChallenge)
router.post('/challengeStatus?:challengeId',challengeController.challengeIdEnabled)

//Result API's
//router.post('/result',resultController.generateResult);
router.post('/result',resultController.generateResult);
router.get('/result?:challengeId',resultController.getReportForTheChallenge);
module.exports = router;



