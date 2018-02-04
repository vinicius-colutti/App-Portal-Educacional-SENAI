<?php
 require_once('dbConnect.php');
 
 $sql = "select image from photo";
 
 $res = mysql_query($con,$sql);
 
 $result = array();
 
 while($row = mysql_fetch_array($res)){
 array_push($result,array('url'=>$row['image']));
 }
 
 echo json_encode(array("result"=>$result));
 
 mysql_close($con);
 ?>
 