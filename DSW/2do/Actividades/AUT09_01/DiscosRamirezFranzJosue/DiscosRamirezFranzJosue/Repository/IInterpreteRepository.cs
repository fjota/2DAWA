using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Repository
{
  public interface IInterpreteRepository
  {
    IEnumerable<Interprete> ListInterpretes();
    IEnumerable<dynamic> GetInterpretesById();
  }
}
