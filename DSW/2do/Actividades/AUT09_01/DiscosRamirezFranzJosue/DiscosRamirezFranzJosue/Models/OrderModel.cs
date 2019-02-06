using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DiscosRamirezFranzJosue.Models
{
  public class OrderModel
  {
    public int[] SortedIndex { get; }
    public string[] SortedNames { get; }

    public OrderModel()
    {
      SortedIndex = new int[]{ 0,1,2,3};
      SortedNames = new string[] {"Orden por defecto", "Alfabéticamanete ascendente (A-Z)",
      "Alfabéticamanete descendente (Z-A)", "Fecha de lanzamiento"};
    }

    
  }
}