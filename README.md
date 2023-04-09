# Pokemon_Services
This is a project where I started to learn about Java Springboot, Docker and the good sides of multiservices in a project named "FiiPractic, Bytex-Java in the world of microservices". Here we created fun little games with pokemons:

 :joystick:   1. PokemonCatalog linked with a PostgreSQL database that stores all the first generation of pokemons.
    
 :game_die:   2. Battle that uses a request from PokemonCatalog to make a team of how many pokemons and see the winner.
    
 :video_game:  3. Breeding that breeds 2 pokemons that we want. We give the id of the pokemon in the request.
    
 :chess_pawn: 4. Whos-That-Pokemon gives a random pokemon with the image black so only the contour will be seen and we have to guess the right pokemon. If we say the incorrect answer, it will appear the correct one on the screen.
    
   :yo_yo:  5. Starting-page (in work) is the main page. If we want to play the game Whos-That-Pokemon we'll click on the button, if we want to breed them we'll right the names and it will automatic transform in the correct id for the Breeding service to do his job. 
