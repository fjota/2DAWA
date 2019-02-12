using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiscosRamirezFranzJosue.Services
{
  public interface IInterpreteService
  {
    Interprete SearchInterpreteById(int id);
    IEnumerable<Interprete> ListInterpretes();
    IEnumerable<Interprete> ListInterpretesByIdTipoDisco(int idTipo);
    bool CreateInterprete(Interprete interprete);
    bool DeleteInterpreteById(int id);
    bool UpdateInterprete(Interprete interprete);
  }
}
