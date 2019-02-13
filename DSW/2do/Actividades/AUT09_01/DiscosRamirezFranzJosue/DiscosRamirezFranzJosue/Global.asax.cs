using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Services;
using SimpleInjector;
using SimpleInjector.Integration.Web;
using SimpleInjector.Integration.Web.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace DiscosRamirezFranzJosue
{
  public class MvcApplication : System.Web.HttpApplication
  {
    protected void Application_Start()
    {
      AreaRegistration.RegisterAllAreas();
      RouteConfig.RegisterRoutes(RouteTable.Routes);
      // Dependency Injector Config 
      Container container = new Container();
      container.Options.DefaultScopedLifestyle = new WebRequestLifestyle();      
      container.Register<IDiscosService, DiscosService>(Lifestyle.Scoped);
      container.Register<IInterpreteService, InterpreteService>(Lifestyle.Scoped);
      container.Register<IFilterService, FilterService>(Lifestyle.Scoped);
      container.Register<IClientesService, ClientesService>(Lifestyle.Scoped);
      container.Register<IUsuariosServices, UsuariosServices>(Lifestyle.Scoped);
      container.RegisterMvcControllers(Assembly.GetExecutingAssembly());
      container.RegisterMvcIntegratedFilterProvider();
      container.Verify();
      DependencyResolver.SetResolver(new SimpleInjectorDependencyResolver(container));
    }

    void Application_Error(object sender, EventArgs e)
    {
      Exception exc = Server.GetLastError();
      //Response.Redirect("/ErrorHandler/Error");
    }
  }
}
