using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DiscosRamirezFranzJosue.Filters
{
  public class AdminFilter : ActionFilterAttribute
  {
    public override void OnActionExecuting(ActionExecutingContext filterContext)
    {
      Usuario user = null;
      if (filterContext.HttpContext.Session["USUARIO"] is Usuario)
      {
        user = filterContext.HttpContext.Session["USUARIO"] as Usuario;
      }
      if (user == null || !user.UsuariosGrupos.Any(g => g.Grupos.Nombre == "admin"))
      {
        filterContext.Result = new ViewResult()
        {
          ViewName = "Error"
        };

      }
     
    }
  }
}