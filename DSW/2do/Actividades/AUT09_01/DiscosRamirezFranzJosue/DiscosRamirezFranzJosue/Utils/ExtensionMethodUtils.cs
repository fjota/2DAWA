using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace DiscosRamirezFranzJosue.Utils
{
  public static class ExtensionMethods
  {    
    public static ExpandoObject ToExpando(this object anonymousObject)
    {
      IDictionary<string, object> anonymousDictionary = new RouteValueDictionary(anonymousObject);
      IDictionary<string, object> expando = new ExpandoObject();
      foreach (var item in anonymousDictionary)
      {
        expando.Add(item);
      }
      return expando as ExpandoObject;
    }
  }
}