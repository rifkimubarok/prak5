using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using webApi.Model;
using webApi.Repositories;

namespace webApi.Controllers
{
    [Route("api/[controller]")]
    public class NotesController : Controller
    {
        public INoteRepository NoteRepository { get; set; }

        public NotesController([FromServices] INoteRepository API)
        {
            NoteRepository = API;
        }

        [HttpGet]
        public IEnumerable<Note> GetAll()
        {
            return NoteRepository.GetAll();
        }

        // GET api/<controller>/5
        [HttpGet("{id}", Name = "GetNote")]        public IActionResult GetById(Guid id)        {            var item = NoteRepository.GetNoteById(id);            if (item == null)            {                return NotFound();            }            return new ObjectResult(item);        }

        // POST api/<controller>
        [HttpPost]        public IActionResult Create([FromBody]Note item)        {            if (item == null)            {                return BadRequest();            }            NoteRepository.Add(item);            return CreatedAtRoute("GetNote", new            {                controller = "Note",                id =            item.Id.ToString()            }, item);        }  
        // PUT api/<controller>/5
        [HttpPut("{id}")]        public IActionResult Update(Guid id, [FromBody]Note item)        {            if (item == null || item.Id != id)            {                return BadRequest();            }            var note = NoteRepository.GetNoteById(id);            if (note == null)            {                return NotFound();            }            NoteRepository.Update(item);            return new NoContentResult();        }

        // DELETE api/<controller>/5
        [HttpDelete("{id}")]        public void Delete(Guid id)        {            NoteRepository.Remove(id);        }
    }
}
