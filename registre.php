<?php
require("db.inc.php");
header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

$json_data = file_get_contents("php://input");

// Decode the JSON data
$data = json_decode($json_data, true);

if ($data === null) {
    echo json_encode(array("status" => "error", "message" => "Invalid JSON data"));
    exit;
}

$firstName = $data['firstName'];
$lastName = $data['lastName'];
$email = $data['email'];
$password = password_hash($data['password'], PASSWORD_DEFAULT); 
$currency = $data['currency'];

try {
    $sql = "INSERT INTO users (firstName, lastName, email, password, currency) 
            VALUES (:firstName, :lastName, :email, :password, :currency)";
    $stmt = $conn->prepare($sql);
    $stmt->bindParam(':firstName', $firstName);
    $stmt->bindParam(':lastName', $lastName);
    $stmt->bindParam(':email', $email);
    $stmt->bindParam(':password', $password);
    $stmt->bindParam(':currency', $currency);
    $stmt->execute();
    $idUser = $conn->lastInsertId();
    echo json_encode(array("status" => "success", "message" => "User registered successfully","idUser" => $idUser));

} catch(PDOException $e) {
    echo json_encode(array("status" => "error", "message" => "Error: " . $e->getMessage()));
}

$conn = null;


?>