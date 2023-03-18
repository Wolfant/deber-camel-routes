import { IsString, IsNumber } from "class-validator";

export class CreateFacturaDto {
    
    @IsNumber()
    id: number
    
    @IsString()
    date: string

    @IsNumber()
    value: number

    @IsString()
    client_id: string

    @IsString()
    client_name: string

 }
