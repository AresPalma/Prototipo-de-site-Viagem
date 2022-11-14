using Microsoft.EntityFrameworkCore;

namespace DVSviagem.API.Models
{
    public class HospedagemDBContext: DbContext
    {

    public HospedagemDBContext(DbContextOptions<HospedagemDBContext> options)
      : base(options)
    { }

    public DbSet<Hospedagem> Hospedagens { get; set; }
}
}