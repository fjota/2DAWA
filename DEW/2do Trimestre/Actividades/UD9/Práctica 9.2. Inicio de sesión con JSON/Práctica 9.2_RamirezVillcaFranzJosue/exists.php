<?php
header('Content-Type: text/txt; charset=utf-8');
$new_user=json_decode(stripslashes($_REQUEST['cadena']));
$exists=false;
$ar=fopen("users.txt","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar) && !$exists) {
	$line=fgets($ar);
	$lista = explode(";",$line);
	for($i = 0; $i < count($lista) - 1; $i++) {

		$user=explode(",",$lista[$i]);

		if($user[0]==$new_user->username){
			$exists=true;  
		}

	}
}

if ($exists) {
	echo "0";
}
else {
	echo "1";
}
?>