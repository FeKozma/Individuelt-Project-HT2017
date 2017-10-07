export * from './add-ad.component'


export class addAdImport {
  constructor(
    public id: number,
    public title: string,
    public author: string,
    public url?: string
  ) {}
}
