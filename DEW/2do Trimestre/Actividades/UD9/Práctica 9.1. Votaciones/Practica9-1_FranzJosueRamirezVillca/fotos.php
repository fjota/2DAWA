<?php
header('Content-Type: text/html; charset=utf-8');
if ($_REQUEST['foto']==0)
  echo "imgs/teide.jpg";
if ($_REQUEST['foto']==1)
  echo "imgs/roque-nublo.jpg";
if ($_REQUEST['foto']==2)
  echo "imgs/caldera-taburiente.jpg";

?>