using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Models
{
  public static class OrderModel
  {

    public static List<SelectListItem> SortedList { get; set; } = new List<SelectListItem>
    {
      new SelectListItem
      {
        Text = "Orden por defecto",
        Value = "0",
        Selected = true
      },
      new SelectListItem
      {
        Text = "Alfabéticamanete ascendente (A-Z)",
        Value = "1",
        Selected = false
      },
      new SelectListItem
      {
        Text = "Alfabéticamanete descendente (Z-A)",
        Value = "2",
        Selected = false
      },
      new SelectListItem
      {
        Text = "Fecha de lanzamiento",
        Value = "3",
        Selected = false
      }
    };

  }
}