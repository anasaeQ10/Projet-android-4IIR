<?php
$db_host="localhost:8889";
$db_name="expensesTracker";
$db_user="root";
$db_password="root";

try{
    $conn= new PDO("mysql:host=$db_host;dbname=$db_name",$db_user,$db_password);
    $conn->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
}catch(PDOException $err){
    die("error connect to database".$err->getMessage());
}



?>