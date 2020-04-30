const mongoose = require('mongoose');


let userSchema = new mongoose.Schema({
    username: {type: String, required: true, max: 100},
    fathersName: {type: String, required: true,max: 100},
    collegeName: {type: String, required: true,max: 100},
    contactNumber:{type: Number,required:true,max :9999999999},
    emailId:{type: String,required:true },
    birthDate:{type: String,required:true},
    address:{type:String,required:true},
    stream:{type:String,required:true},
    course:{type:String,required:true},
    role:{type:String,required:true,default:"student"},
    isEnable:{type:Boolean,default:"true"},
    challengeId:{type:String},
    password:{type:String}
});

const Register = mongoose.model('register', userSchema);
  
module.exports = Register;

