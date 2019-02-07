using DiscosRamirezFranzJosue.Enums;
using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Services
{
  public interface IOrderService
  {
    IEnumerable<Disco> ListDiscosOrdered(Sorted sort);
  }
}
