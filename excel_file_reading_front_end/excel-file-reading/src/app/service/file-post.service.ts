import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { api } from '../common/endpoint';

@Injectable({
  providedIn: 'root',
})
export class FilePostService {
  constructor(private http: HttpClient) {}

  postFile(file: File) {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(
      environment.serviceUrl + api.SENDFILE.postFile,
      formData
    );
  }
}
