<?php
header('Content-Type: text/txt; charset=utf-8');
$new_user=json_decode(stripslashes($_REQUEST['cadena']));
$success=2;
$ar=fopen("users.txt","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar) && $success==2) {
	$line=fgets($ar);
	$lista = explode(";",$line);
	for($i = 0; $i < count($lista) - 1; $i++) {

		$user=explode(",", $lista[$i]);

		if($user[0]==$new_user->username){
			if($user[1]==$new_user->password) {
				$success=0;  
			} else {
				$success=1;
			}
		}

	}
}

echo $success;
?>