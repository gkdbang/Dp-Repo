
const mongoose = require('mongoose');


// Question Schema
const questionSchema = new mongoose.Schema({
    questionType:{type: String, required: true},
    questionTitle: {type: String},
    questionTitleImg: {type: String},
    option1: {type: String},
    option2: {type: String},
    option3: {type: String},
    option4: {type: String},

    option1Img: {type: String},
    option2Img: {type: String},
    option3Img: {type: String},
    option4Img: {type: String},

    correctAnswer:{type:String},


    isEnabled:{type: Boolean},
    createdDate:{type: String},
    createdBy:{type: String},
    updatedDate:{type: String},
    updatedBy:{type: String}
})


// Challenge Schema
const challengeSchema=new mongoose.Schema({
    challengeId:{type:String},
    challengeName:{type: String, required: true},
    durationInMinutes:{type: Number, required: true},
    cutOffMarks:{type: Number},
    startDate:{type: String, required: true},
    endDate:{type: String, required: true},
    isEnabled:{type: Boolean, default:"true"},
    challenges:[questionSchema]
})

// Challenge model
const Challenge=mongoose.model('Challenge',challengeSchema)

module.exports=Challenge;

