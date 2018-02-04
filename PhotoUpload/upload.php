<?php
 
if($_SERVER['REQUEST_METHOD']=='POST'){

 
 
$image = $_POST['image'];
 
 require_once('dbConnect.php');
 
 $sql ="SELECT max(id)+1 as id FROM photo";
 
 $res = mysql_query($sql);
 
 $id = 0;


	
	if($row = mysql_fetch_array($res)){
		$id = $row['id'];
		
	}
 
	
	
	 $path = "uploads/".$id.".jpg";
	 
	 $actualpath = "http://10.107.134.14/PhotoUpload/".$path;
	 
	 $sql = "INSERT INTO photo (image) VALUES ('".$actualpath."')";
	 
	 if(mysql_query($sql)){
	 file_put_contents($path,base64_decode($image));
	 echo "Successfully Uploaded";
	 }

 

 
 mysql_close($con);

 }else{
 echo "Error";
 }
 
 ?>