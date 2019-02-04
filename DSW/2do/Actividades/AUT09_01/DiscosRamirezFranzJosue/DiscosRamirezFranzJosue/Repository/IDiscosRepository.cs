using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Repository
{
  public interface IDiscosRepository
  {
    IEnumerable<dynamic> ListDiscos();
  }
}
