$(function(){
    console.log('hit')
    $('#submitSkills').click(function() {
        console.log(document.getElementById("reasoning").value)
        if (document.getElementById("reasoning").value ==0){
            document.getElementById('errorText').style.display = "block"
        }
        else{
            document.getElementById('errorText').style.display = "none"

        }





    });
    $('#disagreeWithSkills').click(function(){

        document.getElementById('disagreeText').style.display = "block"

    })

})