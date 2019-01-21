<?php
header('Content-Type: text/txt; charset=utf-8');
$new_user=json_decode(stripslashes($_REQUEST['cadena']));
$still_used=false;
$ar=fopen("users.txt","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar) && !$still_used) {
	$line=fgets($ar);
	$lista = explode(";",$line);
	for($i = 0; $i < count($lista) - 1; $i++) {

		$user=explode(",", $lista[$i]);

		if($user[0]==$new_user->username){
			$still_used=true;  
		}

	}
}

if (!$still_used) {
	$ar=fopen("users.txt","a") or
		die("No se pudo abrir el archivo");
	fputs($ar, $new_user->username.",".$new_user->password.";");
	fclose($ar);
	echo "0";
}
else {
	echo "1";
}
?>