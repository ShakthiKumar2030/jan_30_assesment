import { Component } from '@angular/core';
import { FilePostService } from '../../service/file-post.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css',
})
export class HomePageComponent {
  selectedFile: File | null = null;

  constructor(private service: FilePostService) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadFile() {
    if (this.selectedFile) {
      this.service.postFile(this.selectedFile).subscribe(
        (response) => {
          console.log('File uploaded successfully:', response);
        },
        (error) => {
          console.error('Error uploading file:', error);
        }
      );
    } else {
      console.error('No file selected.');
    }
    window.alert('File uploaded successfully');
  }
}
