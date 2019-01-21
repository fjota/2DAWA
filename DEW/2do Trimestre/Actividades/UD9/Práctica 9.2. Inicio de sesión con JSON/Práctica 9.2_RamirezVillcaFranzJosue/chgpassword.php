<?php
header('Content-Type: text/txt; charset=utf-8');
$new_user=json_decode(stripslashes($_REQUEST['cadena']));
$found=false;
$ar=fopen("users.txt","r") or
  die("No se pudo abrir el archivo");
while (!feof($ar) && !$found) {
	$line=fgets($ar);
	$lista = explode(";",$line);
	for($i = 0; $i < count($lista) - 1; $i++) {

		$user=explode(",",$lista[$i]);

		if($user[0]==$new_user->username){
			$found=true;
			$user[1] = $new_user->password;
			$lista[$i]=$user[0].",".$user[1];
		}

	}
}

if ($found) {
	$ar=fopen("users.txt","w") or
		die("No se pudo abrir el archivo");
	for($i = 0; $i < count($lista) - 1; $i++) 
		fputs($ar, $lista[$i].";");
	fclose($ar);
	echo "0";
} else {
	echo "1";
}
?>