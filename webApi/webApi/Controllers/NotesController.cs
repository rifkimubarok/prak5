﻿using System;
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
        [HttpGet("{id}", Name = "GetNote")]

        // POST api/<controller>
        [HttpPost]
        // PUT api/<controller>/5
        [HttpPut("{id}")]

        // DELETE api/<controller>/5
        [HttpDelete("{id}")]
    }
}