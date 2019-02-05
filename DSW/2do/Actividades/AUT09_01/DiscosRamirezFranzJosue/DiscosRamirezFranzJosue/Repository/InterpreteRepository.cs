using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DiscosRamirezFranzJosue.Repository
{
  public class InterpreteRepository : IInterpreteRepository
  {
    private DiscosEntities discosEntities = new DiscosEntities();

    public IEnumerable<dynamic> GetInterpretesById()
    {
      var interpretes = (from itemsInter in discosEntities.Interpretes
                         join discos in discosEntities.Discoes
                         on itemsInter.IdInterprete equals discos.IdInterprete
                         select itemsInter.Interprete1).AsEnumerable().Select(item => item.ToExpando());

      return interpretes;
    }

    public IEnumerable<Interprete> ListInterpretes()
    {
      return discosEntities.Interpretes;
    }
  }
}