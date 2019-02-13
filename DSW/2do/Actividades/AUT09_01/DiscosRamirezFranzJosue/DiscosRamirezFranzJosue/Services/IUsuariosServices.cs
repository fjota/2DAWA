using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Services
{
  public interface IUsuariosServices
  {
    Usuario FindUserByLoginAndPassword(string login, string password);
  }
}
