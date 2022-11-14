using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DVSviagem.API.Models;

namespace DVSviagem.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class HospedagemController : ControllerBase
    {
        private readonly HospedagemDBContext _context;

        public HospedagemController(HospedagemDBContext context)
        {
            _context = context;
        }

        // GET: api/Hospedagem
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Hospedagem>>> GetHospedagens()
        {
            return await _context.Hospedagens.ToListAsync();
        }

        // GET: api/Hospedagem/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Hospedagem>> GetHospedagem(int id)
        {
            var hospedagem = await _context.Hospedagens.FindAsync(id);

            if (hospedagem == null)
            {
                return NotFound();
            }

            return hospedagem;
        }

        // PUT: api/Hospedagem/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutHospedagem(int id, Hospedagem hospedagem)
        {
            if (id != hospedagem.HospedagemId)
            {
                return BadRequest();
            }

            _context.Entry(hospedagem).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!HospedagemExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Hospedagem
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Hospedagem>> PostHospedagem(Hospedagem hospedagem)
        {
            _context.Hospedagens.Add(hospedagem);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetHospedagem", new { id = hospedagem.HospedagemId }, hospedagem);
        }

        // DELETE: api/Hospedagem/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteHospedagem(int id)
        {
            var hospedagem = await _context.Hospedagens.FindAsync(id);
            if (hospedagem == null)
            {
                return NotFound();
            }

            _context.Hospedagens.Remove(hospedagem);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool HospedagemExists(int id)
        {
            return _context.Hospedagens.Any(e => e.HospedagemId == id);
        }
    }
}
