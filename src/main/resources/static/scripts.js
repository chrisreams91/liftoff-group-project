  const dateRadio = document.getElementById('date')

  document.addEventListener('click', (event) => {
      if(event.target && event.target.matches('date')){
          const keyword = document.getElementById("searchTerm");
            keyword.type = "date";
          });
        }
  })