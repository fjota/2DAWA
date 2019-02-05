using DiscosRamirezFranzJosue.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DiscosRamirezFranzJosue.Services
{
  public class InterpreteService : IInterpreteService
  {
    private DiscosEntities discosEntities;

    public InterpreteService(DiscosEntities discosEntities)
    {
      this.discosEntities = discosEntities;
    }
    
    public IEnumerable<Interprete> ListInterpretes()
    {
      return discosEntities.Interpretes;
    }
  }
}