 const dateRadio = document.getElementById('date')

  dateRadio.addEventListener('click', (event) => {
          const keyword = document.getElementById("searchTerm");
            keyword.type = "date";
            console.log("test");

        });