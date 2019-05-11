import { Component, OnInit, Input } from '@angular/core';
import { NavParams } from '@ionic/angular';

@Component({
  selector: 'app-tab4',
  templateUrl: './tab4.page.html',
  styleUrls: ['./tab4.page.scss'],
})
export class Tab4Page implements OnInit {

  // constructor() { }

  ngOnInit() {
  }

  @Input() value: number;
  backdropDismiss = false;
  showBackdrop = false;
  shouldPropagate = false;
}


