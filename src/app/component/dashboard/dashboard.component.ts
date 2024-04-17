import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/model/task';
import { CrudService } from 'src/app/service/crud.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  taskObj : Task = new Task();
  taskArr : Task[] = [];

  addTaskTitleValue : string = '';
  addTaskDescriptionValue : string = '';
  latitude : string = '';
  longitude : string = '';

  
  editTaskTitleValue : string = '';
  editTaskDescriptionValue : string = '';


  constructor(private crudService : CrudService) { }

  ngOnInit(): void {
    this.getLocation();
    this.editTaskTitleValue = '';
    this.editTaskDescriptionValue = '';
    this.addTaskTitleValue = '';
    this.addTaskDescriptionValue = '';
    this.latitude = '';
    this.longitude = '';
    this.taskObj = new Task();
    this.taskArr = [];
    this.getAllTask();
  }
  getAllTask() {
    this.crudService.getAllTask().subscribe(res => {
      this.taskArr = res;
    }, err => {
      alert("Unable to get list of tasks");
    });
  }

  addTask() {
    this.taskObj.title = this.addTaskTitleValue;
    this.taskObj.description = this.addTaskDescriptionValue;
    this.taskObj.latitude = this.latitude;
    this.taskObj.longitude = this.longitude;
    this.crudService.addTask(this.taskObj).subscribe(res => {
      this.ngOnInit();
      this.addTaskTitleValue = '';
    }, err => {
      alert(err);
    })
  }

  editTask() {
    this.taskObj.title = this.editTaskTitleValue;
    this.taskObj.title = this.editTaskDescriptionValue;
    this.crudService.editTask(this.taskObj).subscribe(res => {
      this.ngOnInit();
    }, err=> {
      alert("Failed to update task");
    })
  }

  deleteTask(etask : Task) {
    this.crudService.deleteTask(etask).subscribe(res => {
      this.ngOnInit();
    }, err=> {
      alert("Failed to delete task");
    });
  }

  call(etask : Task) {
    this.taskObj = etask;
    this.editTaskTitleValue = etask.title;
    this.editTaskDescriptionValue = etask.description;
  }

  getLocation(): void {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                this.latitude = position.coords.latitude.toString();
                this.longitude = position.coords.longitude.toString();
            },
            (error) => {
                console.error('Error getting location:', error);
            }
        );
    } else {
        console.error('Geolocation is not supported by this browser.');
    }
}

}