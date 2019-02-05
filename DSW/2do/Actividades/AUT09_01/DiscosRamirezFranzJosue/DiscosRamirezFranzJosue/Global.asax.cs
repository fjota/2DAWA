using DiscosRamirezFranzJosue.Repository;
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
      // Simple Injector set up 
      var container = new Container();
      container.Options.DefaultScopedLifestyle = new WebRequestLifestyle();
      // Register your stuff here
      container.Register<IDiscosService, DiscosService>(Lifestyle.Scoped);
      container.Register<IDiscosRepository, DiscosRepository>(Lifestyle.Scoped);
      container.Register<IInterpreteService, InterpreteService>(Lifestyle.Scoped);
      container.Register<IInterpreteRepository, InterpreteRepository>(Lifestyle.Scoped);
      container.RegisterMvcControllers(Assembly.GetExecutingAssembly());
      container.RegisterMvcIntegratedFilterProvider();
      container.Verify();
      DependencyResolver.SetResolver(new SimpleInjectorDependencyResolver(container));
    }
  }
}
