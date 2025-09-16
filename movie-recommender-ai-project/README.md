# AI-Powered Movie Recommendation System (Java + AI)

## Overview
This is a professional **AI-powered Movie Recommendation System** implemented entirely in **Java** using **Spring Boot**.  
It demonstrates **Java + AI skills** suitable for GitHub showcase for recruiters.

## Features
- Content-based recommendation using **Cosine Similarity** on movie features (genres, attributes).  
- REST APIs: recommend by movie or genre.  
- Easy to extend with real datasets.  
- Demonstrates **Java + AI + Spring Boot** integration.

## API Endpoints
- `GET /movies/list` → List all movies  
- `GET /movies/recommend?movie=Inception&topN=5` → Recommend top 5 similar movies  
- `GET /movies/recommendByGenre?genre=Sci-Fi&topN=5` → Recommend top 5 movies by genre  

## Run Project
```bash
mvn spring-boot:run
```
Open browser or Postman to test endpoints.

## Future Scope
- Add **collaborative filtering** using user ratings.  
- Integrate **real movie datasets** (IMDb, TMDB API).  
- Add **React frontend** for interactive UI.  

## Author
Nayana K J
GitHub: https://github.com/Nayana-git23
