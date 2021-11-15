
 function validate(form) {
       
    
    var errors=[];
    if(form.applicant.value == "")
    {
        errors.push("Applicant empty!");
        
    }
        
    if(form.approved_by.value == ""){
            errors.push("Approved by is empty!");
           
        }
    if(form.designation.value == "" ){
        errors.push("Designation is empty!!");
        
    }
    if(form.date.value == "" ){
        errors.push("Date is empty!");
        
    }
    if(form.description.value == "" ){
        errors.push("Description empty!");
        
    }

    if(errors.length>0){
        var msg = "ERRORS:\n\n";
        for(var i=0;i<errors.length;i++){
            msg+=errors[i]+"\n";
        }
        alert(msg);
        return false;
    }
 }
 