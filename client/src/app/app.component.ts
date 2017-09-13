import { Component } from '@angular/core';
import { Http } from "@angular/http";
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'First Digital Financial';
  private apiUrl = "http://localhost:8080/ping";
  data: any = {};

  constructor(private http: Http) {
    console.log('Pinging server...');
    this.getPing();
    this.getData();
  }

  getData() {
    return this.http.get(this.apiUrl)
      .map((res: Response) => res.json())
  }

  getPing() {
    this.getData().subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }
}
