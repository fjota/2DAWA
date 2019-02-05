using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DiscosRamirezFranzJosue.Services
{
  public interface IDiscosService
  {
    IEnumerable<Disco> ListDiscos();
    IEnumerable<Tipo> ListTipos();
    IEnumerable<Disco> ListDiscosOrdered(Sorted sort);
  }
}
