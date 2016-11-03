<?php
header("Access-Control-Allow-Origin: *");

require 'vendor/autoload.php';
use Mailgun\Mailgun;

if ($_SERVER['REQUEST_METHOD'] != 'POST') {
	echo "Invalid request type 1. What the fuck are you trying to do?";
	die();
}

if (!isset($_POST['name']) || !isset($_POST['subject']) || !isset($_POST['email']) || !isset($_POST['message']) || !isset($_POST['recipient'])) {
	echo "Invalid request type 2. What the fuck are you trying to do?";
	die();
}

$name    = $_POST['name'];
$subject = $_POST['subject'];
$email   = $_POST['email'];
$message = $_POST['message'];
$recipient = $_POST['recipient'];

$html = "<html>From: $name<br>Email: $email<br>Subject: $subject<br>Message: $message<html>";

$mgClient = new Mailgun($mgKey);
$domain = "$mgDomain";

$result = $mgClient->sendMessage($domain, [
    'from'    => "$mgSender",
    'to'      => $recipient,
    'subject' => "$subject | Visitor Message",
    'text'    => "$name, $email, $subject, $message",
    'html'    => $html
]);

echo "Succesfully sent the email!";
