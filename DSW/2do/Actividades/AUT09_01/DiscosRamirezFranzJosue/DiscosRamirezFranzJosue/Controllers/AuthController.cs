using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Services;
using DiscosRamirezFranzJosue.Utils;

namespace DiscosRamirezFranzJosue.Controllers
{
  public class AuthController : Controller
  {

    private IUsuariosServices usuariosServices;
    public AuthController(IUsuariosServices usuariosServices)
    {
      this.usuariosServices = usuariosServices;
    }
    public ActionResult Login()
    {
      return View();
    }

    [HttpPost]
    public ActionResult Login(Usuario usuario)
    {      
      if (ModelState.IsValid)
      {
        Usuario authUser = null;
        authUser = usuariosServices.FindUserByLoginAndPassword(usuario.Login, usuario.Password.HashStringSHA256());        
        
        if (authUser != null)
        {
          FormsAuthentication.SetAuthCookie(authUser.Login, false);
          Session["USUARIO"] = authUser;
          return RedirectToAction("Index", "Admin");
        }
        else
        {
          ModelState.AddModelError("", "Usuario ó contraseña incorrectos");
          return View();
        }

      }
      return View();
    }

    public ActionResult Logout()
    {
      FormsAuthentication.SignOut();
      Session["USUARIO"] = null;
      return RedirectToAction("Index", "Home");
    }

  }
}