const User = require('../models/user.model');
const Challenge=require('../../Challenge/models/challenge');
const mongoose = require('mongoose');



let encString;
let userExist;

//Simple version, without validation or sanitation
exports.test = function (req, res) {
    res.send('Greetings from the Test controller!');
};


//for registration
exports.regis= async function(req,res){

    // checking Student already exist or not
    let user = await User.findOne({emailId : req.body.emailId});
    
    let challenge=await Challenge.findOne({challengeName:req.body.challengeName.toLowerCase()});
    console.log(challenge.challengeId);

    if(user){
        console.log("user already exist ");
        res.status(401).send("User already exists");
    }
    else if(challenge==null){
        res.status(400).send("Invalid URL");
    }
    else{

        console.log(challenge.isEnabled);
        if(challenge.isEnabled==false)
        {
            res.status(400).send("Test is not enabled");
        }
        else{
    
        const register = new User({
            username:req.body.username,
            fathersName:req.body.fathersName,
            collegeName:req.body.collegeName,
            contactNumber:req.body.contactNumber,
            emailId: req.body.emailId,
            birthDate:req.body.birthDate,  
            address: req.body.address,
            stream: req.body.stream,
            course:req.body.course,
            challengeId:challenge.challengeId,
            password:req.body.contactNumber
        });
        register.save()
          .then(register => {
       
            res.status(201).send("Registration Succesful");
          })
          .catch(err => {
            res.status(500).json({ message: err.message });
          });

        
    }
}

}

// get All Student
exports.getAllUser = async (req,res)=>{
    console.log("GetAll====")
    try {
        let user = await User.find();
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}


// get All Student
exports.getAllUser = async (req,res)=>{
    console.log("GetAll====")
    try {
        let user = await User.find();
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

// get Student by emailId
exports.getUserByEmailId = async (req,res)=>{
    console.log('===================>', req.originalUrl)

    var queryStr = req.query.emailId; 

    console.log('id==>', queryStr);
    try {
        console.log("From getUserByEmailId : ",req.query.emailId);
        let user = await User.findOne({emailId : req.query.emailId});
        console.log(user);
        res.json(user);       
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

// update students
exports.updateUser = async (req,res)=>{
    try {
        console.log(req.params.id);
        console.log(req.body);
        let user = await User.findByIdAndUpdate(req.params.id,req.body).select();
        res.json(user);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

// deactivate all user
exports.deActivateUsers = async (req,res)=>{
    try {
        let user=await User.updateMany({"$set": { "isEnable": "false" } });
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

// Activate all user
exports.activateUsers = async (req,res)=>{
    try {
        let user=await User.updateMany({"$set": { "isEnable": "true" } });
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

// deactivateOneUser by emailId
exports.deActivateOneUser=async(req,res)=>{
    try {
        let user=await User.findOne({emailId : req.query.emailId}).updateOne({"isEnable": "false"});
        console.log('Updated succesfully')
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

// ActivateOneUser by emailId
exports.activateOneUser=async(req,res)=>{
    try {
        let user=await User.findOne({emailId : req.query.emailId}).updateOne({"isEnable": "true"});
        console.log('Updated succesfully')
        res.json(user);
    } catch (error) {
        res.send("Somthing Went Wrong ! ");
    }
}

//for login with name+contactnumber
//password is contact number
exports.loginUser=function(req,res){
    User.findOne({emailId:req.body.emailId},function(err,user){
        console.log("From Request Body : " + req.body.emailId +" "+req.body.password);
        if(err)
        {
            console.log("something wwnt wrong");
            res.json(err);
        }
        else if(user==null){
            console.log("Credentials are not correct !");
            res.status(401).send("This emailId does not exist.");
        }
        else if(user.isEnable===false){
            console.log("user is not active");
            res.status(401).send("User is not active");
        }
        else if(user && user.password===req.body.password)
        {
           res.json(user);
        }
        else
        {
            console.log("invalid user");
            res.status(401).send("Invalid Credentials")
        }
    });
}


exports.changePassword = async(req,res)=>{
    let user=await User.findOne({emailId:req.body.emailId});
    console.log("From Request Body : " + req.body.emailId +" "+req.body.password);
    console.log(user.contactNumber);
    if(user.password===req.body.password){
        user.password=req.body.newPassword;
        let userData=await User.findOne({emailId:req.body.emailId}).updateOne(user);
        res.status(201).send(userData);
    }
    else{
        res.send("Old password is incorrect");
    }
}