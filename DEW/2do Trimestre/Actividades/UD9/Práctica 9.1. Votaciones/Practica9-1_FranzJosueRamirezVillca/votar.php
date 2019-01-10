<?php
header('Content-Type: text/html; charset=utf-8');
$foto=$_REQUEST['foto'];
$voto=$_REQUEST['voto'];
$archivo="votos".$foto.".txt";
$ar=fopen($archivo,"a") or
  die("No se pudo abrir el archivo");
fputs($ar,$voto.",");
fclose($ar);
$ar=fopen($archivo,"r") or
  die("No se pudo abrir el archivo");
while (!feof($ar))
{
  $linea=fgets($ar);
  echo $linea;
}
fclose($ar);
?>