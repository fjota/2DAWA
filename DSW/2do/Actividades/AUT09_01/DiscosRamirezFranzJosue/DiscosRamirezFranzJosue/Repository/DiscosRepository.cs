using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using DiscosRamirezFranzJosue.Models;
using DiscosRamirezFranzJosue.Utils;

namespace DiscosRamirezFranzJosue.Repository
{
  public class DiscosRepository : IDiscosRepository
  {
    private DiscosEntities discosEntities = new DiscosEntities();

    public IEnumerable<dynamic> ListDiscos()
    {
      var discos = (from disc in discosEntities.Discoes
                    join interpretes in discosEntities.Interpretes
                    on disc.IdInterprete equals interpretes.IdInterprete
                    select new
                    {
                      disc.IdDisco,
                      disc.Titulo,
                      disc.Agno,
                      interpretes.Interprete1
                    })
                   .AsEnumerable().Select(items => items.ToExpando());
      return discos;
    }

  }
}