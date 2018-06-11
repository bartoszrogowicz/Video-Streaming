
export class Stream {


  constructor(id: number, name: String, description: String, url: String) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.url = url;
  }

  id: number;
  name: String;
  description: String;
  url: String
}
