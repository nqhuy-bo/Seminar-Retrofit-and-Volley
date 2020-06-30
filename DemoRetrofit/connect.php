<?php
   
     $con =mysqli_connect("localhost","root","","dbretrofit");
     mysqli_query($con,"SET NAMES 'utf8'");

     $email=$_POST['email'];
     $password=$_POST['password'];
     $query_check_user="select * from sinhvien where email= '$email' and password = '$password'";

     $result= mysqli_query($con,$query_check_user);
     if(mysqli_num_rows($result) == 0)
     {
     	$response['success']=false;
     	$response['message']="không có user";
     }
     else
     {
     	$row= mysqli_fetch_assoc($result);

     	$response['success']=true;
     	$response['message']="truy cập thành công";

     	$response['email']=$row['email'];
     	$response['username']=$row['username'];
     	$response['sdt']=$row['sdt'];
     	$response['password']=$row['password'];
     }

echo json_encode($response);

?>