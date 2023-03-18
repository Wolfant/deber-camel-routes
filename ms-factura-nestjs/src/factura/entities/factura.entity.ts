import { Entity, Column, PrimaryGeneratedColumn } from "typeorm";


@Entity()
export class Factura {

    @PrimaryGeneratedColumn()
    uuid: number

    @Column()
    id: number

    @Column()
    date: string

    @Column()
    value: number

    @Column()
    client_id: string

    @Column()
    client_name: string

} 
