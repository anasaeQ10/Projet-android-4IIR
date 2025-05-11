<?php
header("Content-Type: application/json");
require("db.inc.php");

// Enable CORS 
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Headers: Content-Type");

$data = json_decode(file_get_contents("php://input"), true);


if (empty($data['email']) || empty($data['password'])) {
    http_response_code(400);
    die(json_encode(["status" => "error", "message" => "Email and password are required"]));
}

try {
    $stmt = $conn->prepare("SELECT * FROM users WHERE email = :email LIMIT 1");
    $stmt->bindParam(':email', $data['email']);
    $stmt->execute();
    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    if (!$user || !password_verify($data['password'], $user['password'])) {
        http_response_code(401);
        die(json_encode(["status" => "error", "message" => "Invalid credentials"]));
    }

    
    unset($user['password']);
    echo json_encode([
        "status" => "success",
        "message" => "Login successful",
        "user" => $user
    ]);

} catch (PDOException $e) {
    http_response_code(500);
    die(json_encode(["status" => "error", "message" => "Database error"]));
}
?>